package hello.mail;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	JavaMailSender javaMailSender;
	
	private void save(Person person) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(person.getEmail());
		mailMessage.setText("Szia " + person.getUserName() + "\n Ezt az emailt " + new Date() + " időpontban kaptad meg");
		javaMailSender.send(mailMessage);
		
		personRepository.save(person);
	}
	
	public Iterable<Person> findAll() {
		return personRepository.findAll();
	}

	public void savePerson(Person person) {
		save(person);
	}
}
