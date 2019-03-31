package utilities.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="vNombre")
public class ValidarNombre implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		String nombre=(String)arg2;
		if(nombre.length()<6) {
			throw new ValidatorException(new FacesMessage("Su nombre debe tener al menos 5 caracteres"));
		}
	}

}
