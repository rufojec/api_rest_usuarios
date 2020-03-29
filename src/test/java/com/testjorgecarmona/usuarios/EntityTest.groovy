package com.testjorgecarmona.usuarios

import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser
import com.pruebajorgecarmona.user.entitys.Phone
import com.pruebajorgecarmona.user.entitys.User
import com.pruebajorgecarmona.user.service.IUserService
import com.pruebajorgecarmona.user.service.IValidationService
import com.pruebajorgecarmona.user.service.IValidationServiceImpl
import spock.lang.Specification

public class EntityTest extends Specification{

	public void "Crear una entidad usuario correctamente"() {
		
		given:"una entidad usuario"
		User user = new User();
		List<Phone> listPhone = new ArrayList<Phone>();
		Phone phone = new Phone();
		phone.setNumber(1265);
		phone.setCitycode(2);
		phone.setContrycode("cl");
		listPhone.add(listPhone);
		Date date = new Date();
		
		when:"el usuario este bien formado con sus entidades"
		user.setName("nombre prueba");
		user.setEmail("correo@correo.cl");
		user.setPassword("passC9");
		user.setPhones(listPhone);
		user.setCreated(date);
		
		
		then:"obtener sus valires mediante sus metodos accesadores"
		String nombre = user.getName();
		String email = user.getEmail();
		String pass = user.getPassword();
		String phones = user.getPhones().get(0);
		String created = user.getCreated().toString();
	}
	
}
