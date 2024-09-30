public class ProblemasRVersionNormal {

    static int sinTresCincoSiete(int num){
        int nuevoNum = 0;
        int digito = 0;
        int c = 1;
        while (num != 0){
            digito = num % 10;
            if (digito != 3 && digito != 5 && digito != 7) {
                nuevoNum = nuevoNum + digito * c;
                c = c * 10;
            }
            num = num / 10;
        }
        return nuevoNum;
    }

    static int combinarNumeros (int n1, int n2){
        int numeroCobinado = 0;
        int c = 1;
        while(n1 > 0 || n2 > 0){

            if(n2 != 0){
                numeroCobinado += (n2 % 10) * c;
                c *= 10;
                n2 /= 10;
            }
            if(n1 != 0){
                numeroCobinado += (n1 % 10) * c;
                c *= 10;
                n1 /= 10;
            }

        }


        return numeroCobinado;
    }

    static int[] separarNumeros (int n){
        int[] nums = new int[2];
        int c = 1;

        while(n > 0){
            
            if(n < 10){
                nums[0] += (n % 10) * c;
                n /= 10;
            }else{
                nums[1] += (n % 10) * c;
                n /= 10;
                nums[0] += (n % 10) * c;
                n /= 10;
                c *= 10;
                
            }
            
        }
        return nums;
    }



    static String cadenaSinVocales (String cadena){
        String texto = "";

        for (int i = 0; i < cadena.length(); i++) {
            switch (cadena.charAt(i)) {
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
                    
                    break;
                 
                default:
                    texto += cadena.charAt(i);
                    break;
            }
        }

        return texto;
    }


    


    static int sumatoria(int[] nums){
        int suma = 0;
        for(int n : nums){
            suma += n;
        }
        return suma;
    }



    static int[] multiplos (int [] nums, int x){
        int c = 0;

        for (int i : nums) {
            if(i % x == 0) c+=1;
        }

        int[] multiplos = new int[c];

        c = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % x == 0){
                multiplos[c] = nums[i];
                c++;
            } 
        }
        return multiplos;
    }



    static int[] combinarArreglos (int[] a, int[] b){
        int[] r = new int[a.length + b.length];
        int j = 0;

        for (int i = 0; i < ((a.length >= b.length)? a.length : b.length); i++){
            if (i < a.length) r[j++] = a[i];
            if (i < b.length) r[j++] = b[i];
        }
        return r;
    }


    static int[] combinarArreglosPorPares (int[] a, int[] b){
        int[] r = new int[a.length + b.length];
        int c, j = 0;
        if(a.length >= b.length) c = a.length;
        else c = b.length;

        for (int i = 0; i < c; i++){

            if(i < a.length && i < b.length && a[i] > b[i]){
                r[j++] = a[i];
                r[j++] = b[i];
                continue;
            }
            if(i < a.length && i < b.length && a[i] < b[i]){
                r[j++] = b[i];
                r[j++] = a[i];
                continue;
            }
            if (i < a.length) r[j++] = a[i];
            if (i < b.length) r[j++] = b[i];
            
        }
        return r;
    }





    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        //System.out.println(sinTresCincoSiete(732947));
        //System.out.println(combinarNumeros(8293, 362));
        //System.out.println(separarNumeros(8329238)[0] + " "+  separarNumeros(8329238)[1]);
        //System.out.println(cadenaSinVocales("nUllabei"));
        //System.out.println(multiplosE(array, 4));

        // int [] a =  {32,43,12};
	    // int [] b =  {90,49,54,23};

	    // int [] r = combinarArreglos(a, b);
        // int [] s = combinarArreglosPorPares(a, b);
	    
	    // for(int i : r){
        //     System.out.print(i + " ");
        // }

        // System.out.println();

	    // for(int i : s){
        //     System.out.print(i + " ");
        // }

        int[] x = multiplos(array, 2);
        for (int i : x) {
            System.out.print(i+" ");
        }
        

    }


    


}
