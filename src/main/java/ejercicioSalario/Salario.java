package ejercicioSalario;

public class Salario {

    double salarioMin=2000;
    public double descuento(double sueldo) throws Exception{
        if(sueldo<0){
            throw Exception("");
        }
        double descuento=0;
        if(sueldo>(salarioMin*2)){
            descuento=sueldo*15/100;
        } else if(sueldo > salarioMin){
            descuento=sueldo*5/100;
        }
        return sueldo-descuento;
    }
}
