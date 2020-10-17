class Main{
    public static void main(String[] args){
        //REPRESENTAR A BASE DE DADOS (CONJUNTO COM OS EXEMPLOS CONHECIDOS)
        int[][] simpsons = {
            {0, 250, 36, 1}, //Homer - 1 Masc
            {10, 150, 34, 2}, //Marge - 2 Fem
            {2, 90, 10, 1},
            {6, 78, 8, 2},
            {4, 20, 1, 2},
            {1, 170, 70, 1},
            {8, 160, 41, 2},
            {10, 180, 38, 1},
            {6, 200, 45, 1}
        }

        //REPRESENTAR O EXEMPLO DESCONHECIDO
        int[] comic = {8, 290, 38, -1} //-1 = conceito indefinido

        // USAR O ALGORITMO "VIZINHO MAIS PROXIMO" PARA IDENTIFICAR O CONCEITO DESSE EXEMPLO
        int conceito = vizinhoMaisProximo(simpsons, comic);
        
        //MOSTRAR O CONCEITO IDENTIFICADO
        System.out.println("Conceito: " + conceito);
    }

    public static double obterEuclidiana(int[] conhecido, int[] desconhecido){
        //FORMULA DISTANCIA EUCLIDIANA
        double distancia = 0;
        for (int i = 0; i < conhecido.length - 1; i++){
            distancia += Math.pow(conhecido[i] - desconhecido[i], 2);
        }
        return Math.sqrt(distancia);
    }

    public static int vizinhoMaisProximo(int[][] conhecimento, int[] desconhecido){
        // OBTER A DISTANCIA DE TODOS OS EXEMPLOS CONHECIDOS EM RELAÇÃO AO EXEMPLO DESCONHECIDO
        double menorDistancia = obterEuclidiana(conhecimento[0], desconhecido);
        int maisProximo = 0;
        for (int i = 1; i < conhecimento.length; i++){
            double distancia = obterEuclidiana(conhecimento[i], desconhecido);

            // IDENTIFICAR O EXEMPLO COM MENOR FREQUENCIA
            if (distancia < menorDistancia){
                menorDistancia = distancia;
                maisProximo = i;
            }
        }

        // RETORNA O CONCEITO (CLASSE) DO EXEMPLO MAIS PROXIMO
        return conhecimento[maisProximo][3];
    }
}