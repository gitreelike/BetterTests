package ex80

import geb.Page

class GooglePage extends Page {

    static url = 'http://www.google.de'

    static at = { title == 'Google' }

    static content = {
        searchField { $(name: 'q')}
        searchResults { $('#search .g .r')}
        results { searchResults.collect { it.text() } }
    }

    void search(String searchTerm) {
        searchField << searchTerm
        searchField << '\n'

        waitFor {
            searchResults
        }
    }

    List<String> viewResults() {
        results
    }
}
