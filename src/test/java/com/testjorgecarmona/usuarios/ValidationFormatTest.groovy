package com.testjorgecarmona.usuarios

import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser
import com.pruebajorgecarmona.user.entitys.User
import com.pruebajorgecarmona.user.service.IUserService
import com.pruebajorgecarmona.user.service.IValidationService
import com.pruebajorgecarmona.user.service.IValidationServiceImpl
import spock.lang.Specification

public class ValidationFormatTest extends Specification{

	public void "No permitir email de usuario con formato incorrecto"() {
		
		given:"un correo mal formado sin el formato correcto"
		Boolean isValid;
		IValidationServiceImpl validation = new IValidationServiceImpl();
		String correo = "correomalo.sinformato"
		
		when:"el correo sea detectado como invalido por el servicio de validación"
		isValid = validation.emailFormatValidate(correo);
		
		then: "el servicio debe indicar que el correo es invalido"
		isValid == false
	}
	
	public void "Permitir email de usuario con formato correcto"() {
		
		given:"un correo correctamente formado"
		Boolean isValid;
		IValidationServiceImpl validation = new IValidationServiceImpl();
		String correo = "pruebamail@gmail.com"
		
		when:"el correo sea detectado como valido por el servicio de validación"
		isValid = validation.emailFormatValidate(correo);
		
		then: "el servicio debe indicar que el correo es correcto "
		isValid == true
	}
	
	public void "Permitir contraseña de usuario con formato correcto"() {
		
		given:"un password correctamente formado"
		Boolean isValid;
		IValidationServiceImpl validation = new IValidationServiceImpl();
		String password = "pruebaTest2"
		
		when:"La contraseña sea validada por el servicio"
		isValid = validation.passwordFormatValidate(password);
		
		then: "el servicio debe indicar que la contraseña es correcta "
		isValid == true
	}
	
}
