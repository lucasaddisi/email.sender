package main;

import java.util.Properties;

import data.Mail;
import services.MailSenderService;

public class Main {

	public static void main(String[] args) {
		Mail mail = new Mail("lucas.simix@gmail.com"
				, "Mail automatizado.", "Pensé que iba a ser más dificil.");
		MailSenderService service = new MailSenderService();
		
		service.send(mail);

	}

}
