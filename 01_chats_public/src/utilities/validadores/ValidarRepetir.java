package utilities.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="vPsw")
public class ValidarRepetir implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		String psw1=(String)((UIInput)arg1.findComponent("psw1")).getValue();
		String psw2=(String)arg2;
		if(!psw1.equals(psw2)) {
			throw new ValidatorException(new FacesMessage("La contraseña deben ser iguales"));
		}
	}

}
