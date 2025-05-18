public class Acta {
    private final Estudiante estudiante;
    private final int nota;

    private final int copia;

    public Acta (int Newnota, Estudiante estudiante){
        this.nota=Newnota;
        this.estudiante=estudiante;
        this.copia=0;
    }

    private Acta (int Newnota, Estudiante estudiante, int nuevo){
        this.nota=Newnota;
        this.estudiante=estudiante;
        this.copia=nuevo;
    }

    public boolean esOriginal(){
        if(copia==0){
            return true;
        }else{
            return false;
        }

    }

    public Acta withEstudiante(Estudiante e) {
        return new Acta( this.nota,e,copia+1);
    }

    public Acta withNota(int n){
        return new Acta (n,this.estudiante,copia+1);
    }


}
