package myself;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@ManagedBean
public class Zad3 implements Validator {

	private HtmlInputText peselComp;
	private HtmlInputText urodzinyComp;

	private Date urodziny;
	private String pesel;

	public Date getUrodziny() {
		return urodziny;
	}

	public void setUrodziny(Date urodziny) {
		this.urodziny = urodziny;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public HtmlInputText getPeselComp() {
		return peselComp;
	}
	public void setPeselComp(HtmlInputText peselComp) {
		this.peselComp = peselComp;
	}
	public HtmlInputText getUrodzinyComp() {
		return urodzinyComp;
	}
	public void setUrodzinyComp(HtmlInputText urodzinyComp) {
		this.urodzinyComp = urodzinyComp;
	}
	
	@Override
	public void validate(FacesContext ctx, UIComponent c, Object value)
			throws ValidatorException {
		
		System.out.println("TEST");
		String pesel = (String)value;
		Date urodziny = (Date)urodzinyComp.getValue();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		if (!pesel.startsWith(sdf.format(urodziny))) {
			throw new ValidatorException(new FacesMessage("zle"));
		}
	}

}

