package ejercicioReserva;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class ReservaTest {

    Otros otroMock = Mockito.mock(Otros.class);
    @ParameterizedTest
    @CsvSource(
            {
                    "La Paz, 3, 23, 3,2023,Lunes,true, el dia Lunes 23 Marzo 2023 existen 3 pasajes para La Paz",
                    "La Paz, 2, 23, 3,2023,Martes,true, el dia Martes 23 Marzo 2023 existen 2 pasajes para La Paz",
                    "La Paz, 0, 23, 3,2023,Miercoles,true, CANTIDAD NO VALIDA",
                    "La Paz, -5, 23, 3,2023,Jueves,true, CANTIDAD NO VALIDA",
                    "Santa Cruz, 20, 28, 3,2023,Viernes,true, CANTIDAD NO VALIDA",
            }
    )
    public void verifyMaxPrestamo(String destino, int cantidad, int dia, int mes, int gestion, String day, boolean hayPasajes, String expected){
        MockedStatic<Otros> otrosStatic = Mockito.mockStatic(Otros.class);
        otrosStatic.when(() -> Otros.getDay(dia, mes, gestion)).thenReturn(day);

        Mockito.when(otroMock.existenPasajes(destino,cantidad)).thenReturn(hayPasajes);

        Reserva reserva = new Reserva();
        reserva.setOtro(otroMock);
        String actual = reserva.reservaVuelo(destino, cantidad, dia, mes, gestion);
        Assertions.assertEquals(expected, actual, "ERROR: no devuelve el texto correcto o no alerta que se ingresaron datos erroneos");
        otrosStatic.close();
    }
}
