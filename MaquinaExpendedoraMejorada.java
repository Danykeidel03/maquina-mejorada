public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // Es la cuenta de billetes
    private int cuentaBillete;
    // Cantidad Maxima de billetes
    private int cantidadMaximaBilletes;
    //Descuento
    private double porcentajeDeDEscuento;
    // El precio del billete
    private boolean descuento;
    // El cantidad de billetes
    private int cantidadBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete,int billetesMaximos, String origen, String destino, boolean codigoDescuento ) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        cantidadBillete = 0;
        cuentaBillete = 1;
        descuento = codigoDescuento;
        porcentajeDeDEscuento = 0.10;
        cantidadMaximaBilletes = billetesMaximos;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadBillete >= cantidadMaximaBilletes) {
            System.out.println("No es posible introducir mas dinero ");
        }
        else{
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }     
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDineroQueFalta = precioBillete - balanceClienteActual; 
        if (cantidadDineroQueFalta <= 0) {     
            if (cantidadBillete >= cantidadMaximaBilletes) {
                System.out.println("No es posible imprimir billete ");
            }
            else{
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                if (descuento == true) {
                    if (cuentaBillete == 3) {
                    System.out.println("Has recibido un descuento de " + precioBillete * porcentajeDeDEscuento + " euros.");
                    cuentaBillete = 0;
                }
                }
            
                System.out.println("##################");
                System.out.println();         

                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                cantidadBillete = cantidadBillete + 1;
                cuentaBillete = cuentaBillete + 1;

            }
        }

        else {
            System.out.println("Necesitas introducir " + (cantidadDineroQueFalta) + " euros mas!");

        }
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 

    /**
     * Saca todo el dinero introducido
     */
    public int vaciarDineroDeLaMaquina() {
        int cantidadDeDineroADevuelta = -1;
        if (totalDineroAcumulado == 0) {        
            cantidadDeDineroADevuelta = balanceClienteActual + totalDineroAcumulado;
            balanceClienteActual = 0;
        }
        else {
            System.out.println("Operacion En Curso ");
        }  
        return cantidadDeDineroADevuelta;
    }

    /**
     * Devuelve El Numero de Billetes Vendidos
     */
    public int getNumeroBilletesVendidos() {
        return cantidadBillete ;
    }

} 

