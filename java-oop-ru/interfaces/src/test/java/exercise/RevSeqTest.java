package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RevSeqTest {

    @Test
    void testReversedSequence() {
        var result = new ReversedSequence("sand").toString();
        var expected = "dnas";
        assertThat(result).isEqualTo(expected);
    }
}
