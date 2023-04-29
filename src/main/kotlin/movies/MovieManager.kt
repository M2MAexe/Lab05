package movies

import user_exceptions.SetOverflowException
import java.time.LocalDate
import java.util.*

/**
 * Movie manager representative class
 */
class MovieManager {
    private val movieQueue: HashSet<Movie> = HashSet<Movie>()
    private val creationDate: LocalDate = LocalDate.now()
    private val maxElements = 10000
    private var countElements = 0

    /**
     * Get movie queue method
     *
     * @return queue of movies [PriorityQueue]
     * @author Markov Maxim 2023
     */
    fun getMovieQueue() = Collections.unmodifiableSet(movieQueue)

    /**
     * add movie to collection method
     *
     * @argument new element of collection [Movie]
     * @return true if element was added.
     * @author Markov Maxim 2023
     */
    fun addMovie(movie: Movie): Boolean {
        if (countElements >= maxElements) throw SetOverflowException()
        movieQueue.add(movie)
        countElements++
        return true
    }

    /**
     * remove element by id from collection
     *
     * @argument id element id from collection
     * @return true if element was deleted.
     * @author Markov Maxim 2023
     */
    fun removeElementById(id: Long): Boolean {
        var elementToDelete : Movie? = null
        for (element in movieQueue) {
            if (element.getId() == id) {
                elementToDelete = element
            }
        }

        if (elementToDelete != null) {
            movieQueue.remove(elementToDelete)
            countElements--
            return true
        }

        return false
    }

    /**
     * get collection creation date
     *
     * @return collection creation date [LocalDate]
     * @author Markov Maxim 2023
     */
    fun getCreationDate() = creationDate

    /**
     * get collection class
     *
     * @return class of collection
     * @author Markov Maxim 2023
     */
    fun getCollectionClass() = movieQueue.javaClass

    /**
     * get number of collection elements
     *
     * @return number of elements in collection
     * @author Markov Maxim 2023
     */
    fun getCollectionNumberOfElements() = movieQueue.size
}
