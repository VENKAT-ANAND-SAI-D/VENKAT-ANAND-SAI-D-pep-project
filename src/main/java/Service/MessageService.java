package Service;

import Model.Message;
import DAO.MessageDAO;

import java.util.List;

public class MessageService {

    MessageDAO messageDAO;

    public MessageService(){
        messageDAO = new MessageDAO();
    }

    public MessageService(MessageDAO messageDAO){
        this.messageDAO = messageDAO;
    }

    public Message createMessage(Message message){
        if (((message.getMessage_text() != null) && (!message.getMessage_text().isEmpty())) && (message.getMessage_text().length() <= 255) && (messageDAO.checkPostedBy(message.getPosted_by()) != null)){
            return this.messageDAO.insertMessage(message);
        }
        return null;
    }

    public List<Message> getAllMessages(){
        return this.messageDAO.getAllMessages();
    }
    
    public Message getMessageById(int id){
        return this.messageDAO.getMessageById(id);
    }

    public Message deleteMessage(int id){
        Message message = messageDAO.getMessageById(id);
        if (message != null){
            this.messageDAO.deleteMessageById(id);
            return message;
        }
        return null;
    }

    public Message updateMessage(Message message, int id){
        if ((this.messageDAO.getMessageById(id) != null) && ((message.getMessage_text() != null) && (!message.getMessage_text().isEmpty())) && (message.getMessage_text().length() <= 255)){
            this.messageDAO.updateMessageById(message, id);
            return this.messageDAO.getMessageById(id);
        }
        return null;
    }

    public List<Message> getMessagesByUserId(int id){
        return this.messageDAO.getAllMessagesByAcoountId(id);
    }
}
