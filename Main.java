import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

class main {
   public static void main(String[] args) throws Exception {
        DataSource arff = new DataSource("simpsons.arff");
        
        // INSTANCIANDO CONJUNTO DE DADOS A PARTIR DA ORIGEM DEFINIDA
        Instances simpsons = arff.getDataSet();

        // EXIBINDO OS DADOS DO CONJUNTO
        System.out.println(simpsons);
    }
}