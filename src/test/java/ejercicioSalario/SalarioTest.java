package ejercicioSalario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SalarioTest {

    @ParameterizedTest
    @CsvSource(
            {
                    "5600,4760",
                    "5500, 4675",
                    "4500,3825",
                    "4000, 3800",
                    "2500, 2375",
                    "2001, 1900.95",
                    "2000,2000",
                    "1000,1000",
                    "500, 500",
            }
    )
    public void verifyDescuento(double sueldo, double expectedResult) throws Exception{
        Salario salario = new Salario();
        double actualResult = salario.descuento(sueldo);
        Assertions.assertEquals(expectedResult, actualResult,"ERROR: descuento incorrecto");
    }
}
//crea otro paquete que inicie con minuscula y move tu TEst, se debio cachear