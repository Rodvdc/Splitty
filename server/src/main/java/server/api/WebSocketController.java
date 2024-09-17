package server.api;


import commons.Event;

import commons.Expense;
import commons.Participant;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.messaging.simp.SimpMessagingTemplate;

import org.springframework.stereotype.Controller;

import server.database.ExpenseRepository;
import server.database.ParticipantRepository;

import java.util.List;



@Controller
public class WebSocketController {
    private final SimpMessagingTemplate messagingTemplate;
    private ParticipantRepository participantRepo;
    private ExpenseRepository expenseRepo;

    /**
     * Constructor for the WebSocketController
     * @param participantRepo
     * @param expenseRepo
     * @param messagingTemplate
     */
    @Autowired
    public WebSocketController(ParticipantRepository participantRepo, ExpenseRepository expenseRepo,
                               SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
        this.participantRepo = participantRepo;
        this.expenseRepo = expenseRepo;
    }

    /**
     * Sends an updated event to the clients
     * @param invitecode the invite code of the event
     * @param event the event that was updated
     */
    public void sendUpdatedEvent(String invitecode, Event event){
        System.out.println("Sending updated event to " + "/topic/event/" + invitecode);
        messagingTemplate.convertAndSend("/topic/event/" + invitecode, event);
    }

    /**
     * Sends an updated list of participants to the clients
     * @param invitecode the invite code of the event
     */
    public void sendUpdatedParticipants(String invitecode){
        System.out.println("Sending updated participants to " + "/topic/participants/" + invitecode);
        List<Participant> participants = participantRepo.findByEventInviteCode(invitecode).get();
        messagingTemplate.convertAndSend("/topic/participants/" + invitecode, participants);
    }

    /**
     * Sends an updated list of expenses to the clients
     * @param event the event that was updated
     */
    public void sendUpdatedExpenses(Event event){
        System.out.println("Sending updated expenses to " + "/topic/expenses/" + event.getInviteCode());
        List<Expense> expenses = expenseRepo.findByParentEvent(event).get();
        messagingTemplate.convertAndSend("/topic/expenses/" + event.getInviteCode(), expenses);
    }
}
