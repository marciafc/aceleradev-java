package br.com.spring.data.livro.service;

import br.com.spring.data.livro.model.Livro;
import br.com.spring.data.livro.repository.LivroRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LivroServiceImplTest {

    @InjectMocks
    private LivroServiceImpl livroServiceImpl;

    @Mock
    private LivroRepository livroRepository;

    @Test
    public void testFindMaiorMediaAvaliacao() {
        mockFindLivrosComAvaliacao();
        assertEquals(new Integer(4), livroServiceImpl.findByMaiorMediaAvaliacao().getMediaAvaliacoes());
    }

    private void mockFindLivrosComAvaliacao() {
        Livro livro = mock(Livro.class);
        when(livro.getMediaAvaliacoes()).thenReturn(4);
        when(this.livroRepository.findComAvaliacao()).thenReturn(Arrays.asList(livro));
    }


}