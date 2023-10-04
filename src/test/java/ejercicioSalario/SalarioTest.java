package ejercicioSalario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SalarioTest {

    Salario salario;
    @BeforeEach
    public void setup(){
        salario = new Salario();
    }
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
        double actualResult = salario.descuento(sueldo);
        Assertions.assertEquals(expectedResult, actualResult,"ERROR: descuento incorrecto");
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "0",
                    "-5600",
                    "-5500",
                    "-4500",
                    "-4000",
                    "-2500",
                    "-2001",
                    "-2000",
                    "-1000",
                    "-500",
            }
    )
    public void verifySueldoNotValid(double sueldo) throws Exception {
        Assertions.assertThrows(Exception.class, () -> {
            salario.descuento(sueldo);
        });
    }

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
    public void verifyDescuentoStatic(double sueldo, double expectedResult) throws Exception{
        double actualResult = Salario.descuentoStatic(sueldo);
        Assertions.assertEquals(expectedResult, actualResult,"ERROR: descuento incorrecto");
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "0",
                    "-5600",
                    "-5500",
                    "-4500",
                    "-4000",
                    "-2500",
                    "-2001",
                    "-2000",
                    "-1000",
                    "-500",
            }
    )
    public void verifySueldoNotValidStatic(double sueldo) throws Exception {
        Assertions.assertThrows(Exception.class, () -> {
            Salario.descuentoStatic(sueldo);
        });
    }
}
//crea otro paquete que inicie con minuscula y move tu TEst, se debio cachear