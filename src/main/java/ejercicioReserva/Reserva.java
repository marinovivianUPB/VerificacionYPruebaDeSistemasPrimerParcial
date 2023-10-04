package ejercicioReserva;

public class Reserva {

    Otros otro = new Otros();

    public void setOtro(Otros otro) {
        this.otro = otro;
    }

    public String reservaVuelo(String destino, int cantidad, int dia, int mes, int gestion){
        if(dia < 1 || mes < 1 || gestion < 2023 || dia > 31 || mes > 12 || dia>28 && mes==2 && !isLeapYear(gestion) || dia>29 && mes==2 && isLeapYear(gestion)
        || (dia > 30 && (mes==4||mes==6||mes==9||mes==11)) ){
            return "FECHA NO VALIDA";
        }
        if(cantidad < 1 || cantidad >80){
            return "CANTIDAD NO VALIDA";
        }
        String month="";
        switch(mes){
            case 1:
                month="Enero";
                break;
            case 2:
                month="Febrero";
                break;
            case 3:
                month="Marzo";
                break;
            case 4:
                month="Abril";
                break;
            case 5:
                month="Mayo";
                break;
            case 6:
                month="Junio";
                break;
            case 7:
                month="Julio";
                break;
            case 8:
                month="Agosto";
                break;
            case 9:
                month="Septiembre";
                break;
            case 10:
                month="Octubre";
                break;
            case 11:
                month="Noviembre";
                break;
            case 12:
                month="Diciembre";
                break;
        }
        return otro.existenPasajes(destino, cantidad) ? "el dia "+Otros.getDay(dia,mes,gestion)+" "+dia+" "+month+" "+gestion+" existen "+cantidad+" pasajes para "+destino : "no existen suficientes pasajes para "+destino ;
    }

    public boolean isLeapYear(int num){
        return (num%4==0 && (num%100!=0||num%400==0));
    }
}
