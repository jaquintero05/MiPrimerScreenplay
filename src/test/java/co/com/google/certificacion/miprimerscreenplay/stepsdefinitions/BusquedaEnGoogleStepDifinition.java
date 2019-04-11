package co.com.google.certificacion.miprimerscreenplay.stepsdefinitions;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.core.Is.is;

import java.nio.channels.SeekableByteChannel;

import org.openqa.selenium.WebDriver;

import co.com.google.certificacion.miprimerscreenplay.exceptions.FraseNoEnContrada;
import co.com.google.certificacion.miprimerscreenplay.questions.LaFrase;
import co.com.google.certificacion.miprimerscreenplay.tasks.BuscarUnaFrase;
import co.com.google.certificacion.miprimerscreenplay.userinterfaces.GoogleHomePage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

public class BusquedaEnGoogleStepDifinition {
	
	GoogleHomePage googleHomePage;
	
	@Managed(driver = "chrome")
    private WebDriver hisBrowser;
    private Actor juan = Actor.named("juan quintero");
		
    @Before
	 public void actorCanBrowseTheWeb() {
	        juan.can(BrowseTheWeb.with(hisBrowser));
	   }
	
	
	@Given("^Juan esta en el sitio de google$")
	public void juanEstaEnElSitioDeGoogle() throws Exception {
		juan.wasAbleTo(Open.browserOn().the(googleHomePage));
	
	}


	@When("^el busca la palabra \"([^\"]*)\"$")
	public void elBuscaLaPalabra(String palabraUno){
		juan.attemptsTo(BuscarUnaFrase.composedOfTheWords(palabraUno));	
	}

	@Then("^el verifica la palabra \"([^\"]*)\" este en el resultado$")
	public void elVerificaLaPalabraEsteEnElResultado(String ResultadoEsperado)  {
	
		//arturo.should(seeThat(ThePhrase.searched(), is(resultadoEsperado))); 
		juan.should(seeThat(LaFrase.searched(), is(ResultadoEsperado)).orComplainWith(FraseNoEnContrada.class, FraseNoEnContrada.franceNoEnContrada ));
	}
		
	
			}
	


