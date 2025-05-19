public class Calculadora {
    public static String avaliar(String expressao) {
        if (expressao.contains("^")) {
            String[] partes = expressao.split("\\^");
            double base = Double.parseDouble(partes[0]);
            double expoente = Double.parseDouble(partes[1]);
            return String.valueOf(Math.pow(base, expoente));

        } else if (expressao.contains("√")) {
            String parte = expressao.replace("√", "");
            double valor = Double.parseDouble(parte);
            return String.valueOf(Math.sqrt(valor));

        } else if (expressao.contains("!")) {
            String parte = expressao.replace("!", "");
            int valor = Integer.parseInt(parte);
            return String.valueOf(fatorial(valor));

        } else if (expressao.contains("+")){
            String[] partes = expressao.split("\\+");
            double soma = 0;
            for (String parte : partes) {
                soma += Double.parseDouble(parte);
            }
            return String.valueOf(soma);

        } else if (expressao.contains("-")) {
            String[] partes = expressao.split("-");
            double resultado = Double.parseDouble(partes[0]);
            for (int i = 1; i < partes.length; i++) {
                resultado -= Double.parseDouble(partes[i]);
            }
            return String.valueOf(resultado);

        } else if (expressao.contains("*")) {
            String[] partes = expressao.split("\\*");
            double produto = 1;
            for (String parte : partes) {
                produto *= Double.parseDouble(parte);
            }
            return String.valueOf(produto);

        } else if (expressao.contains("/")) {
            String[] partes = expressao.split("/");
            double resultado = Double.parseDouble(partes[0]);
            for (int i = 1; i < partes.length; i++) {
                resultado /= Double.parseDouble(partes[i]);
            }
            return String.valueOf(resultado);

        } else {
            return expressao;
        }
        
    }
    
    public static int fatorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fatorial(n - 1);
    }
}