package xkeys_si;

import java.io.IOException;

import javax.mail.MessagingException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Xkeys_SI {
	
    public static void main(String[] args) {
            	
    	final String HOST= "localhost"; 
		final String NOMBRE_COLA = "xkeys"; 
		
		try {
            ConnectionFactory factory = new ConnectionFactory();
	        factory.setHost(HOST);
	        Connection connection = factory.newConnection();
	        Channel channel = connection.createChannel();
	        channel.queueDeclare(NOMBRE_COLA, false, false, false, null);
		
	        System.out.println("[SERVICIO INTERNO] Esperando mensajes. Para finalizar pulsa CTRL+C.");
    	
	        Consumer consumer = new DefaultConsumer(channel) {
	            @Override
	            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
	        	
	        	    String mensajeSI= new String(body, "UTF-8");	        	
	        	    String[] mensajeSIdiv = mensajeSI.split(";");
	        	
	        	    String direccion = mensajeSIdiv[0];	        	
	        	    String recibo = mensajeSIdiv[1];
        	    
	             
	        	    try {
	        	    	Correo correo = new Correo();
	        	    	correo.enviarCorreo(direccion,"Tu compra de Xkeys",recibo);
	        	    	System.out.println("[SERVICIO INTERNO] Correo enviado a "+direccion+".");
	        	    }catch (MessagingException e) {	        	    	
	        	    	System.out.println ("[SERVICIO INTERNO]Error al enviar el correo.");
	        	    }
	        	    
	            }	    	
	        };
	        channel.basicConsume(NOMBRE_COLA, true, consumer);
	    } catch (Exception e) {
            System.out.println("[SERVICIO INTERNO] No se pudo conectar con RabbitMQ.");	
        }
    }	
}
