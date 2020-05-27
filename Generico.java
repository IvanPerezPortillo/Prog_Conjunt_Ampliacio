/*
 * GENERICOS
 */
package prg.conf_t3_conjunt;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author: Iván Pérez Portillo
 */
public class Generico<T> {

    private ArrayList<T> arraryGenericos; //array para objeto conjunt

    //1. constructor un conjunt→ Es crearà el generic buit, aquell que no te elements
    public Generico() {
        this.arraryGenericos = new ArrayList<>();
    }
    
    //2. constructor de còpia, a partir d’altre generic ja creat.
    public Generico(Generico altre) {
        this.arraryGenericos = altre.arraryGenericos;
    }

    //3. constructor(T[])a partir d’un array de T. Fixar-se que no poden haver 
    //elements repetits. Cas de hi haure no donarà error, però evitarà duplicats.not
    public Generico(T numero[]) {
        if (this.arraryGenericos == null) {//si no hay array
            this.arraryGenericos = new ArrayList<>();
        }
        for (T i : numero) {
            if (!this.arraryGenericos.contains(i)) {//si no contiene el elemento
                this.arraryGenericos.add(i);
            }
        }

    }

    //4. size→retorna el número d’elements del generic. Per exemple Q.size()=6
    public int size() {
        if (this.arraryGenericos != null) { // si no es null
            int resultado = this.arraryGenericos.size();
            return resultado;
        } else {// si es null devuelve 0
            return 0;
        }
    }

    //5. contains(element)→retorna un boolean indicant si l’element pertany o no al generic. 
    // Per exemple Q.contains(8)=true,Q.contains(4)=false.
    public boolean contains(T element) {
        if (this.arraryGenericos == null) {// si es nulo 
            return false;
        }
        return this.arraryGenericos.contains(element);
    }

    //6. afegir(element)→afig el element al nostre generic, cas de no estar ja. 
    //Retorna les dades del generic un cop afegit el nom element o el que tenia.
    public int afegir(T element) {
        if (this.arraryGenericos == null) { // si es nulo esta vacio
            this.arraryGenericos = new ArrayList<>();
            this.arraryGenericos.add(element);
        }
        if (!this.arraryGenericos.contains(element)) { //Si no lo contiene
            this.arraryGenericos.add(element);
        }
        return size();
    }

    //7. eliminar(element)→elimina, cas d’estar el element. Retorna true si ha pogut eliminar-se 
    //o false en cas contrari.
    public boolean eliminar(T element) {
        if (this.arraryGenericos == null) {// si es nulo o vacio
            return false;
        }
        if (this.arraryGenericos.contains(element)) {// si lo contiene lo quito
            this.arraryGenericos.remove((Integer) element);// realizo un casting ya que el método está sobrecargado
            return true;
        } else {//ya no lo contiene
            return false;
        }

    }

    //8. esBuit→ens diu si el generic està buit. Retorna un booleà. Per exempleP.esBuit()=false,R.esBuit()=true
    public boolean buit() {
        return this.arraryGenericos.size() <= 0; //si es 0 o < en true

    }
    
    //9. equals(Generico)→ens diu si un generic és igual o no respecte a altre donat
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.arraryGenericos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Generico other = (Generico) obj;
        for (int i = 0; i < this.arraryGenericos.size(); i++) {//completamente iguales
            if (!other.arraryGenericos.contains(this.arraryGenericos.get(i))) {
                return false;
            }

        }
        return true;
    }

    //10. toString()→el mostra per pantalla, separant els elements per comes i tancats entre claus.
    @Override
    public String toString() {
        String res = "{";
        for (int i = 0; i < arraryGenericos.size(); i++) {
            res += arraryGenericos.get(i);
            if (i < arraryGenericos.size() - 1) {
                res += ", ";
            }
        }
        res += "}";
        return res;

    }

    //11. unio(Generico)→crea un nou conjunt amb tots els elements del primer i del que passem com argument. 
    //Per exemple P.unio(Q)={6, 13, 1, 7, 14, 5, 9, 11, 8, 2, 4, 12, 3,16}
    public Generico unio(Generico altre) {
        //creo el nuevo
        Generico salida = new Generico(this);//obj salida es igual a generico

        for (int i = 0; i < altre.arraryGenericos.size(); i++) {
            if (!this.arraryGenericos.contains(altre.arraryGenericos.get(i))) {//si generio no contiene de altre
                salida.arraryGenericos.add(altre.arraryGenericos.get(i));// lo meto salida
            }
        }
        return salida;

    }

    //12. interseccio(Generico)→crea un nou conjunt amb els elements que pertanyen a els dos conjnts. 
    //Per exemple P.interseccio(Q)={7,5,8}
    public Generico interseccio(Generico altre) {
        Generico salida = new Generico();//creo objeto de copia
        for (int i = 0; i < this.arraryGenericos.size(); i++) {
            if (altre.arraryGenericos.contains(this.arraryGenericos.get(i))) {//si en Generico están en altre
                salida.arraryGenericos.add(this.arraryGenericos.get(i));
            }
        }

        return salida; // devuelvo conjunto nuevo

    }

    //13. diferencia(Generico)→crea un nou conjunt amb els element que pertanyan al primer conjunt però no al segon,
    // com si fora una resta.  Per exemple P.diferencia(Q)={6,13,1,14,9,11,2,4}
    public Generico diferencia(Generico altre) {
        Generico salida = new Generico();// nuevo generico para devolver
        for (int i = 0; i < this.arraryGenericos.size(); i++) {
            if (!altre.arraryGenericos.contains(this.arraryGenericos.get(i))) {//si es diferente Generico están en altre
                salida.arraryGenericos.add(this.arraryGenericos.get(i));
            }
        }

        return salida;

    }

    //14. diferenciaSimetrica(Generico)→crea un nou conjunt amb els elemnts que pertanyan alprimer conjunt però no 
    //al segon, afegint-li els que pertanyan al segon conjunt però no al primer. P.diferenciaSimetrica(Q)={6,13,1,14,9,11,2,4,12,3,16}. 
    //De manera senzilla la diferència simètrica és la unió menys la intersecció
    public Generico diferenciaSimetrica(Generico altre) {
        Generico salida = new Generico();
        for (int i = 0; i < this.arraryGenericos.size(); i++) {
            if (!altre.arraryGenericos.contains(this.arraryGenericos.get(i))) {
                salida.arraryGenericos.add(this.arraryGenericos.get(i));
            }
        }
        for (int i = 0; i < altre.arraryGenericos.size(); i++) {
            if (!this.arraryGenericos.contains(altre.arraryGenericos.get(i))) {
                salida.arraryGenericos.add(altre.arraryGenericos.get(i));
            }
        }

        return salida;
    }

    //15. inscrit(Generico)→retorna un boolea quan el primer conjunt està dins del passat com argument, és a dir, 
    //quan tots els elements del conjunt pertanyen al segon conjunt també. Per exemple T.inscrit(P)=true,Q.inscrit(P)=false,T.inscrit(Q)=true
    public boolean inscrit(Generico altre) {
        boolean encontrado = false;
        if (this.arraryGenericos == null) {
            return false;
        }
        for (int i = 0; i < this.arraryGenericos.size(); i++) {
            encontrado = false;
            for (int j = 0; j < altre.arraryGenericos.size(); j++) {
                if (this.arraryGenericos.get(i) == altre.arraryGenericos.get(j)) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado == false) {
                return false;
            }
        }
        return true;

    }
}//FIN

