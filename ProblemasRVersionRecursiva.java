import java.util.*;
public class ProblemasRVersionRecursiva {
    static int sinTresCincoSiete(int num){
        if(num == 0) return 0;
        else{
            int digito = num % 10;
            if(digito != 3 && digito != 5 && digito != 7) return sinTresCincoSiete(num / 10) * 10 + digito;
            else return sinTresCincoSiete(num / 10);
            
        }
    }
    
    
    static int combinarNumeros (int n1, int n2, int c){
        if(n1 == 0 && n2 == 0){
            return 0;
        }
        else{
            int numeroCombinado = 0;
            if(n2 != 0){
                numeroCombinado += (n2 % 10) * c;
                c *= 10;
            }
            if(n1 != 0){
                numeroCombinado += (n1 % 10) * c;
                c *= 10;
            }

            return numeroCombinado + combinarNumeros(n1 / 10, n2 / 10, c);
        }

    }

    static int[] separarNumero (int n, int c, int[] nums){

        if(n == 0){
            return nums;
        }
        else{
                nums[1] += (n % 10) * c;
                n /= 10;
                nums[0] += (n % 10) * c;

                return separarNumero(n/10, c*10, nums);
        }
    }


    static String cadenaSinVocales (String cadena) { 

           if(cadena.equals("")){
                return cadena;
           }

           switch (cadena.charAt(0)) {
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                return cadenaSinVocales(cadena.substring(1));
             
            default:
                return cadena.charAt(0) + cadenaSinVocales(cadena.substring(1));
        }

    }




    

    static int sumatoria(int[] nums, int c){
        if(c == nums.length){
            return 0;
        }else{
            return nums[c] + sumatoria(nums, c + 1);
        }

    }


    //contar los mulriplos de un arreglo y devolverlos en uno nuevo

    static int contar (int[] a, int n, int i){
        if(a == null) return 0;
        if(i == a.length) return 0;
        if(a[i]%n == 0) return 1 + contar(a, n, i + 1);
        return contar(a, n, i + 1);
    }
    static int[] repartir(int[] a, int[] b, int n, int i, int j){
        if(a == null || b == null) return new int[]{};
        if(j == b.length || i == a.length) return b;
        
        if(a[i]%n == 0){
            b[j] = a[i];
            return repartir(a, b, n, i+1, j+1);
        }
        return repartir(a, b, n, i+1, j);
    }
    static int [] multiplos(int[] a, int n){
        int t = contar(a, n, 0);

        int[] b = new int[t];
        return repartir(a, b, n, 0, 0);

    }


    static int[] combinarArreglos(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        int[] mayor;
        if(a.length > b.length) mayor = a;
        else mayor = b;
        combinador(a, b, mayor, c, 0, 0, mayor.length);
        return c;
    }
    static int[] combinador(int[] a, int [] b, int[] mayor, int [] c, int i, int j, int limite){

        if(a == null || b == null) return c;
        if(i == limite) return c;
        
        if(i < a.length && i < b.length){
            c[j] = a[i];
            j+=1;
            c[j] = b[i];
            return combinador(a, b, mayor, c, i+1, j+1, limite);

        }
        else{
            c[j] = mayor[i];
            return combinador(a, b, mayor, c, i+1, j+1, limite);
        }
    }


    static int[] combinarArreglosPorPares(int[] a, int[] b){
        int[] c = new int[a.length + b.length];
        int[] mayor;
        if(a.length > b.length) mayor = a;
        else mayor = b;
        combinadorPorPares(a, b, mayor, c, 0, 0, mayor.length);
        return c;
    }
    static int[] combinadorPorPares(int[] a, int [] b, int[] mayor, int [] c, int i, int j, int limite){
        if(a == null || b == null) return c;
        if(i == limite) return c;
        if(i < a.length && i < b.length){
            if (a[i] > b[i]) {
                c[j] = a[i];
                j += 1;
                c[j] = b[i];
            } else {
                c[j] = b[i];
                j += 1;
                c[j] = a[i];
            }
            return combinadorPorPares(a, b, mayor, c, i+1, j+1, limite);
        }
        else{
            c[j] = mayor[i];
            return combinadorPorPares(a, b, mayor, c, i+1, j+1, limite);
        }
    }
    
     


    public static void main(String[] args) {
        //System.out.println(sinTresCincoSiete(724463));
        //System.out.println(cadenaSinVocales("hola mundo"));
        // int[] array = new int[]{1,2,3,4,5};
        // System.out.println(sumatoria(array, 0));
        //System.out.println(combinarNumeros(84293, 3462, 1));

        // int[] nums = new int[2];
        // nums = separarNumero(8239632, 1, nums);
        // for(int i : nums){
        //     System.out.print(i + " ");
        // }



        // int[] array = new int[]{1,2,3,4,5,6,7,8,9,10};
        // int[] array2 = multiplos(array, 2);

        // for (int i : array2) {
        //     System.out.println(i);
        // }
        
        // int [] a =  {32,50,12};
	    // int [] b =  {90,49,54,23};

        // int [] r = combinarArreglosPorPares(a, b);

        // for(int i : r){
        //     System.out.print(i + " ");
        // }

        
        
    }
}
