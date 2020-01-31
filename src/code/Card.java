package code;

public class Card {

	private int couleur;
	private int valeur;
	
    public final static String[] COULEURS = {"Pic", "Coeur", "Trefle", "Carreau"};
    public final static String[] VALEURS = {"As", "Deux", "Trois", "Quatre", "Cinq", "Six", "Sept", "Huit", "Neuf", "Dix", "Valet", "Dame", "Roi"};
    
    public Card(int c, int v) {
    	this.couleur = c;
    	this.valeur = v;
    }

	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public int getCouleur() {
		return couleur;
	}

	public int getValeur() {
		return valeur;
	}

	public String toString() {
    	StringBuffer sb = new StringBuffer();
    	sb.append(Card.VALEURS[this.valeur]);
    	sb.append(" de ");
    	sb.append(Card.COULEURS[this.couleur]);
    	return sb.toString();
    }
}
