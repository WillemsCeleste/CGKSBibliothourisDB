package be.cegeka.bibliothouris.domain.books;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

public class BookServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void addBook_shouldReturnBookRepository() throws Exception {
        bookService.addBook("12345", "Erwins angels", "Boegiewoegie", "Erwin");

        verify(bookRepository).addBook(new Book("12345", "Erwins angels", "Boegiewoegie", "Erwin"));
    }

    @Test
    public void getAllBooks() throws Exception {
        Book book1 = new Book("12345", "Erwins angels", "Boegiewoegie", "Erwin");
        Book book2 = new Book("12346", "Erwins devils", "Boegiewoegie", "Erwin");
        Book book3 = new Book("12347", "Erwins demons", "Boegiewoegie", "Erwin");

        when(bookRepository.getAllBooks()).thenReturn(Arrays.asList(book1, book2, book3));

        assertThat(bookService.getAllBooks()).containsOnly(book1, book2, book3);
    }
}