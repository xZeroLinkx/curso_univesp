class AreaPiscina {
    // Materias da piscina
    static final int alvenaria = 0;
    static final int vinil = 1;
    static final int fibra = 2;
    static final int plastico = 3;

    // Preço dos materiais
    double[] precos;

    // Nomes dos materiais
    static String[] nomes = {
        "Alvenaria",
        "Vinil",
        "Fibra",
        "Plastico"
    };

    // Valor do raio
    double raio;

    AreaPiscina(){
        // this(new double[] {1500, 1100, 750, 500});
        double[] aux = {1500, 1100, 750, 500};
        this.precos = aux;
        this.raio = 10;
    }

    AreaPiscina(double[] precos){
        this.precos = precos;
        this.raio = 10;
    }

    AreaPiscina(double raio){
        this();
        this.raio = raio;
    }

    // Calcula a área da piscina
    double area(){
        return (this.raio >= 0 ? (Math.PI * Math.pow(this.raio, 2)) : -1);
    }

    // Calcula o valor do metro quadrado para piscina
    double valor(double area, int material){
        if(material < alvenaria || material > plastico || area < 0)
            return(-1);

        return (area * precos[material]);
    }

    // Retorna a matriz com os preços finais.
    // Parâmetros:
    //     val - matriz de valores
    //     desc - matriz de descontos
    double[][] calculaFinal(double[][] val, double[][] desc){
        double[][] saida = new double[val.length][val[0].length];

        for(int i = 0; i < saida.length; i++){
            for(int j = 0; j < saida[0].length ; j++){
                saida[i][j] = val[i][j] * (1 - desc[i][j]);
            }
        }

        return (saida);
    }

    // Carrega os valores das piscinas na matriz de área x material
    void carregaVal(double[][] m){
        for(int i = 0; i < m.length; i++){ //Linhas material
            for(int j = 50; j <= 200; j += 50){ //Colunas áreas
                m[i][j / 50 - 1] = valor(j, i);
            }
        }
    }

    public static void main(String[] args){
        // Aqui vão os testes
        // Verifica as referências das strings
        String str1 = "Exemplo";
        String str2 = new String("Exemplo");
        String str3 = "Outro exemplo";

        if(str1 == str2){} // False
        if(str1 == str3){} // False
        str3 = str1;
        if(str1 == str3){} // True

        // Troca uma letra da string
        String b = "Meu string";

        System.out.println(b.charAt(4));

        char[] b2 = b.toCharArray();
        b2[4] = 'b';
        b = String.valueOf(b2);
        // ou b = new String(b2);

        System.out.println(b);

        // Concatena valores a string
        String s = "Meu string";

        s += "oba";
        s += 'c';
        s += 4;
        s += 23.5;

        System.out.println(s);

        // Utiliza os métodos equals e length
        String a = "Meu string";
        String a2 = "Meu string";

        System.out.println(a.equals(a2));
        System.out.println(a.length());

        // Demonstra que s1 recebe um novo endereço
        String s1 = "Bom dia";
        String s2 = s1;

        s1 = "Boa noite";
        System.out.println(s2);
    }
}
