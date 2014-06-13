package assignment4.evolution;



/**
 * This is the class with the {@code main} method - it initializes the first
 * generation and then evolves it iteratively.</br>
 * To run the program, follow these steps:
 * 	Run -> Run Configurations... -> Java Application -> Right Click
 * 	-> New -> Main Class: assignment4.evolution.Evolution -> Run</br></br>
 * 
 * Your task is to implement the method {@code evolve()}.</br>
 * It has to manage the transition from one generation to the next.</br>
 * Therefore you will first need to rate the individuals (MastDistibutions)
 * based on their fitness (how well they fulfill the requirements).</br>
 * Second, you have to create a new generation from the old one by using:
 * <ul>
 * <li>selection: fit individuals survive and make it to the next generation
 * <li>crossover: features of fit individuals are recombined
 * <li>mutation: random changes occur, thus varying the genetic material
 * </ul>
 * 
 * This literature might help you get an overview of genetic algorithms or
 * evolutionary programming in general:</br>
 * 
 * <ul>
 * <li>Teske 2013: Computerprogramme züchten. In HPImgzn issue 14, pp. 50-53
 * <li>Saake, Sattler: Algorithmen und Datenstrukturen, 5th edition, pp. 86-88
 * <li>{@link http://en.wikipedia.org/wiki/Genetic_algorithm}
 * </ul>
 *
 * @author Andreas Burmeister
 * 
 * @version 0.3 05/27/14
 * 
 * @see Generation
 * @see MastDistribution
 * @see TransmitterMast
 */

public class Evolution {
	private final long budget;
	private final float minCoverage;
	private MastDistribution solution;
	private Generation currentGeneration;
	private int generationNumber;

	public Evolution(int generationSize, long budget, float minCoverage) {
		currentGeneration = new Generation(generationSize);
	    currentGeneration.randomizeAll(100); //default: 100
	    generationNumber = 1;
	    this.budget = budget;
	    this.minCoverage = minCoverage;
	    check();
	}
	
	public Generation getCurrentGeneration() {
		return currentGeneration;
	}

	public MastDistribution getSolution() {
		return solution;
	}

	public int getGenerationNumber() {
		return generationNumber;
	}
	
	private void check() {
		MastDistribution[] individuals = currentGeneration.getIndividuals();
		for (int i = 0; i < individuals.length; i++) {
			if (individuals[i].coverage() > minCoverage*CountryMap.countrySize &&
				individuals[i].getOverallCost() < budget) {
				solution = individuals[i];
				int a = solution.coverage();
				int b = CountryMap.countrySize;
				System.out.println(
					"HEUREKA!\n" +
					"Generation: " + generationNumber +
					", Individual: " + (i+1) + "\n" +
					"Coverage(3+): " + a + "/" + b + " (" +
					(int)(((float)a/b)*100) + " %)\n" +
					"Cost: " + solution.getOverallCost()
				);
				break;
			}
		}
	}
	
	public void evolve() {
		///////////////////////////////////////////////////////////////////////
		//
		// TODO: implement this method (and maybe helper methods)
		//
		// How does the transition from one generation to the next happen?
		// Which individuals qualify to survive? How do you rate individuals?
		// Will mutations occur? Which kinds? Will there be crossovers? 
		//
		// e.g.:
		// crossover(currentGeneration.getIndividuals()[i], currentGeneration.getIndividuals()[j]);
		// mutate(currentGeneration.getIndividuals()[i]);
		// rateFitness(currentGeneration.getIndividuals()[i]);
		// 
		// Why do you choose to do what you do instead of something else?
		// Please comment everything you do. Help us understand your ideas.
		//
		///////////////////////////////////////////////////////////////////////
		
		// dummy:
		currentGeneration.randomizeAll(100);
		
				
		generationNumber++;
		check();
	}
	

	
	public float rateFitness(MastDistribution individual) {
		float fitness = 0;
		
		//TODO: implement
		// i.e., use individual.getOverallCost() and individual.coverage() to rate fitness ...
		
		return fitness;
	}
	
	public MastDistribution mutate(MastDistribution individual) {
		//TODO: implement
		//i.e., change individual
		return null;
	}
	
	public MastDistribution crossover(MastDistribution... parentIndividuals) {
		//TODO: implement
		//i.e., combine attributes from parents
		return null;
	}
	
	public boolean isTerminated() {
		//TODO: implement
		//e.g., stop after first solution (solution!=null) or try to find better ones?
		return false;
	}

	public static void main(String[] args) {
		long budget = 100000000;
		float minCoverage = 0.9f;
		// The number of individuals in a generation. You may change this parameter
		// if you need to. However, if you choose to change it - leave a comment why.
		int generationSize = 1000;
		Evolution evolution = new Evolution(generationSize, budget, minCoverage);
		
		//stop after "terminated signal or after n iterations (default: 1000)
		while (evolution.isTerminated() && evolution.getGenerationNumber() < 1000) { 
			evolution.evolve();
    	}
	}
}