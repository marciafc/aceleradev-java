package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		return getRandomQuote(repository.findAll());
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		return getRandomQuote(repository.findByActor(actor));
	}

	private Quote getRandomQuote(List<Quote> quotes) {
		return quotes != null && quotes.size() > 0 ?
				quotes.get(RandomUtil.generateRandomValue(quotes.size())) : null;
	}

}
