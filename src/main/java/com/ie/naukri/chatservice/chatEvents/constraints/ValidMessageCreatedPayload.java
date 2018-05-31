package com.ie.naukri.chatservice.chatEvents.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import com.ie.naukri.common.constraints.validators.DefaultConstraintValidator;
import com.ie.naukri.exceptions.models.ErrorCodes;
import org.springframework.util.StringUtils;

import com.ie.naukri.chatservice.chatEvents.constraints.ValidMessageCreatedPayload.MessageValidator;
import com.ie.naukri.chatservice.chatEvents.models.Message;

/**
 * ValidTestMessage annotation for validation of {@link TestMessage} domain
 * model. Each custom annotation must have message, groups, payload and
 * targetField methods like in this annotation.
 * 
 * This is a demo annotation and should be removed from final code.
 *
 * @author Amit Kumar<kumar.amit@naukri.com>
 *
 * @created Jan 9, 2017 11:45:31 AM
 */
@Target({ METHOD, FIELD, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = MessageValidator.class)
public @interface ValidMessageCreatedPayload {

	String message() default "message value must not be null or empty";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	/**
	 * TestMessageValidator class responsible for validating TestMessage.
	 *
	 * @author Amit Kumar<kumar.amit@naukri.com>
	 *
	 * @created Jan 9, 2017 11:46:49 AM
	 */
	public static class MessageValidator extends DefaultConstraintValidator<ValidMessageCreatedPayload, Message> {

		@Override
		protected void addConstraintViolations(Message arg0, ConstraintValidatorContext arg1) {
			// TODO Auto-generated method stub
			
		}

		/* (non-Javadoc)
		 * @see com.ie.naukri.chatservice.chatEvents.constraints.DefaultConstraintValidator#isValidEntity()
		 */
		/*@Override
		protected void addConstraintViolations(TestMessage value, ConstraintValidatorContext context) {
			if(value == null || StringUtils.isEmpty(value.getMessage())) {
				context.buildConstraintViolationWithTemplate(ErrorCodes.FIELD_NULL.getErrorCode() + ": Must not be null or empty").addPropertyNode("value").addConstraintViolation();
			}
		}*/
	}
}
