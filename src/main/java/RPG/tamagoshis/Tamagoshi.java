package RPG.tamagoshis;

import java.util.Random;

public class Tamagoshi {
	private int age;
	private int maxEnergy;
	private int energy;
	private int maxFun;
	private int fun;
	private static int lifeTime =10;
	private String name;
	private Random random = new Random();
	
	
	public int getAge() {
		return age;
	}
	


	public int getEnergy() {
		return energy;
	}

	public static int getLifeTime() {
		return lifeTime;
	}
	
	
	public String getName() {
		return name;
	}

	public Tamagoshi(String name) {
		super();
		this.name = name;
		this.age = 0;
		this.maxEnergy = random.nextInt(10-5)+5;
		if(this.maxEnergy<8) {
			this.energy = random.nextInt(8-3)+3;
		}
		else {
			this.energy = random.nextInt(maxEnergy+1-3)+3;
		}
		this.maxFun = random.nextInt(10-5)+5;
		if(this.maxFun<8) {
			this.fun = random.nextInt(8-3)+3;
		}
		else {
			this.fun = random.nextInt(maxEnergy+1-3)+3;
		}
		
	}
	
	public String info() {
		StringBuilder message = new StringBuilder();
		if(this.energy>=maxEnergy && this.fun>=this.maxFun) {
			message.append("Tout va bien");
		}
		else {
			boolean plus = false;
			if(this.energy<maxEnergy) {
				message.append("Je meurs de faim");
				plus = true;
			}
			if(this.fun<maxFun) {
				if(plus) {
					message.append(" et ");
				}
				message.append("Je m'ennuis");
			}
		}
		return message.toString();
		
	}

	
	public boolean parle() {
		if(this.energy>4&&this.fun>4) {
			System.out.println(name + " est Heureux");
			return true;
		}
		else {
			System.out.println(name + " est Malheureux");
			return false;
		}
	}
	
	public boolean mange() {
		if(this.energy>=this.maxEnergy) {
			System.out.println(name + " n'a pas faim");
			return false;
		}
		else {
			this.energy += random.nextInt(4-1)+1;
			if(this.energy>this.maxEnergy) {
				energy = maxEnergy;
			}
			return true;
		}
	}
	public boolean consommeFun() {
		this.fun--;
		if(fun<=0) {
			System.out.println(name + " est KO");
			return false;
		}
		return true;
	}
	
	public boolean joue() {
		if(this.fun>=this.maxFun) {
			System.out.println(name + " ne veut pas jouer");
			return false;
		}
		else {
			this.fun += random.nextInt(4-1)+1;
			if(this.fun>this.maxFun) {
				fun = maxFun;
			}
			return true;
		}
	}
	public boolean consommeEnergie() {
		this.energy--;
		if(energy<=0) {
			System.out.println(name + " est KO");
			return false;
		}
		return true;
	}
	
	public void vieillir() {
		this.age++;
	}

	@Override
	public String toString() {
		return "Tamagashi [age=" + age + ", maxEnergy=" + maxEnergy + ", energy=" + energy + ", name=" + name + "]";
	}



	
	
	
}
