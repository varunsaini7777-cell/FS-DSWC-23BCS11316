class GenomeProcessor {
    private StringBuilder genome;

    public GenomeProcessor(int capacity) {
        genome = new StringBuilder(capacity);
    }

    public void loadData(char[] inputData) {
        for (char ch : inputData) {
            genome.append(ch);
        }
    }

    public void modifySequence(String oldPattern, String newPattern) {
        int index = genome.indexOf(oldPattern);

        if (index != -1) {
            genome.replace(index, index + oldPattern.length(), newPattern);
        }
    }

    public String getGenome() {
        return genome.toString();
    }
}

public class Main {
    public static void main(String[] args) {

        GenomeProcessor processor = new GenomeProcessor(100000);

        char[] input = {
                'A', 'C', 'T', 'G',
                'A', 'A', 'C', 'T',
                'G', 'G'
        };

        processor.loadData(input);

        System.out.println("Original Sequence:");
        System.out.println(processor.getGenome());

        processor.modifySequence("AACT", "TTGA");

        System.out.println("Modified Sequence:");
        System.out.println(processor.getGenome());
    }
}