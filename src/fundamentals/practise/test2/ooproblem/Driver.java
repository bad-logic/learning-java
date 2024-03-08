package fundamentals.practise.test2.ooproblem;

public class Driver {
	public static void main(String[] args) {
		Figure[] objArr = {new HatMaker(),
							new HatMaker(),
							new VeeMaker(),
							new ParallelMaker(),
							new FaceMaker()};
		
		new Driver(objArr);
	}
	public Driver(Figure[] figures){
		final String SPACE = " ";
		for(Figure o : figures){
			System.out.print(o.getFigure()+SPACE);
		}
	}

}
