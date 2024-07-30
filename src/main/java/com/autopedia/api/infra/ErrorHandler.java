package com.autopedia.api.infra;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Void> handleError404(){
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ErrorMessagesDTO>> handleError400(MethodArgumentNotValidException ex){
		List<FieldError> fieldErrors = ex.getFieldErrors();
		
		return ResponseEntity.badRequest().body(fieldErrors.stream().map(ErrorMessagesDTO::new).toList());
	}
	
	public class ErrorMessagesDTO {

		private String field;
		private String message;
		
		public ErrorMessagesDTO(FieldError fieldError) {
			this.field = fieldError.getField();
			this.message = fieldError.getDefaultMessage();
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}
	
}
