package sn.gs.demo.entities;

public class Produit {

    private String ref;

    private int quantite;

    private float pu;

    public Produit() {
        super();
    }

    public Produit(String ref, int quantite, float pu) {
        this.ref = ref;
        this.quantite = quantite;
        this.pu = pu;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPu() {
        return pu;
    }

    public void setPu(float pu) {
        this.pu = pu;
    }


    //On a generer ces 2 delegate methode

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produit other = (Produit) obj;
        if (ref == null)
        {
            if (other.ref != null)
                return false;
        } else if (!ref.equals(other.ref))
            return false;
        return true;

    }

    @Override
    public int hashCode() {
       final int prime = 31;
       int result = 1;
       result = prime * result + ((ref == null) ? 0 : ref.hashCode());
       return  result;
    }
}
