package co.com.google.certificacion.miprimerscreenplay.questions;




import co.com.google.certificacion.miprimerscreenplay.userinterfaces.GoogleResultpage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("validar resultado")
public class LaFrase implements Question<String>{

	public LaFrase() {
		
	}
	
	@Override
	public String answeredBy(Actor actor) {
		// TODO Auto-generated method stub
		return GoogleResultpage.SEARCH_BAR.resolveFor(actor).waitUntilVisible().getValue();
		
	}
	
	public static LaFrase searched() {
		return new LaFrase();
	}
	

}
