package RPG.characters;

public abstract class Personnage{
    private String image ;

    public Personnage(String image) {
        this.image = image;
    }

    public abstract void affectHero();

    public String getImage(){
        return this.image;
    }
    public abstract String whoIam();

}
