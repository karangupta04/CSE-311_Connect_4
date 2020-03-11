
public class Controller {
private Model model;
private View view;

public Controller(Model model) {
	this.model=model;
	this.view=new View();
	//view = new View(this, model);
}

public void reset() {
	model.resetGame();
}
public void dropCoin(int columnNumber) {
	
	model.dropCoin(columnNumber);
}

}
