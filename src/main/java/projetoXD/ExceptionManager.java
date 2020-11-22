package projetoXD;

import java.util.NoSuchElementException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import projetoXD.locadora.LocadoraDuplicadaException;
import projetoXD.locadora.LocadoraNaoIdendificadoException;

@ControllerAdvice
public class ExceptionManager {
	@ExceptionHandler({ NoSuchElementException.class, EmptyResultDataAccessException.class,
			LocadoraNaoIdendificadoException.class })
	public ResponseEntity<Void> handleNotFound() {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(LocadoraDuplicadaException.class)
	public ResponseEntity<Void> handleConflict() {
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}


}