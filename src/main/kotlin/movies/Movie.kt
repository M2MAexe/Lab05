package movies

import user_exceptions.EmptyStringException
import user_exceptions.MaxValueException
import user_exceptions.ValueLessThanZeroException
import java.time.LocalDate
import kotlin.math.max

/**
 * Person representation class
 */
class Person(private val name: String, private val height: Int,
             private val hairColor: Color, private val nationality: Country) {
    init {
        if (name.isEmpty()) throw EmptyStringException("Person need's name")
        if (name.contains(",")) throw EmptyStringException("Name can't use symbol ','")
        if (height <= 0) throw ValueLessThanZeroException("Height can't be less than zero")
    }

    /**
     * Name getter method
     *
     * @return person name [String]
     * @author Markov Maxim 2023
     */
    fun getName() = this.name

    /**
     * Height getter method
     *
     * @return person height [Float]
     * @author Markov Maxim 2023
     */
    fun getHeight() = this.height

    /**
     * Hair color getter method
     *
     * @return person hair color [Color]
     * @author Markov Maxim 2023
     */
    fun getHairColor() = this.hairColor

    /**
     * Nationality getter method
     *
     * @return person nationality [Country]
     * @author Markov Maxim 2023
     */
    fun getNationality() = this.nationality

    override fun toString(): String = "Name: $name Height: $height Hair Color: $hairColor Nationality: $nationality"
}

class Coordinates(private val x: Float, private val y: Double) {
    init {
        if (y > 424)
            throw MaxValueException("Y can't be more than 424")
    }

    /**
     * X getter method
     *
     * @return x coordinate [Float]
     * @author Markov Maxim 2023
     */
    fun getX() = this.x

    /**
     * Y getter method
     *
     * @return y coordinate [Double]
     * @author Markov Maxim 2023
     */
    fun getY() = this.y

    override fun toString(): String {
        return "X: $x Y: $y"
    }
}

class Movie {
    private var name: String
    private var coordinates: Coordinates
    private var oscarsCount: Long
    private var length: Int
    private var genre: MovieGenre
    private var mpaaRating: MpaaRating
    private var screenWriter: Person
    private var id: Long
    private var creationDate: LocalDate

    constructor(name: String, coordinates: Coordinates,
                oscarsCount: Long, length: Int,
                genre: MovieGenre, mpaaRating: MpaaRating,
                screenWriter: Person, id: Long, date: LocalDate) {
        if (name.isEmpty()) throw EmptyStringException("Movie name can't be empty")
        if (name.contains(",")) throw EmptyStringException("Movie name can't use symbol ','")
        if (oscarsCount <= 0) throw ValueLessThanZeroException("Oscars count needs to be more than zero")
        if (length <= 0) throw ValueLessThanZeroException("Length needs to be more than zero")

        this.name = name
        this.coordinates = coordinates
        this.oscarsCount = oscarsCount
        this.length = length
        this.genre = genre
        this.mpaaRating = mpaaRating
        this.screenWriter = screenWriter

        this.id = id
        cntId = max(id, cntId)
        this.creationDate = date
        }
    constructor(name: String, coordinates: Coordinates,
                oscarsCount: Long, length: Int,
                genre: MovieGenre, mpaaRating: MpaaRating,
                screenWriter: Person, id: Long) {
        if (name.isEmpty()) throw EmptyStringException("Movie name can't be empty")
        if (name.contains(",")) throw EmptyStringException("Movie name can't use symbol ','")
        if (oscarsCount <= 0) throw ValueLessThanZeroException("Oscars count needs to be more than zero")
        if (length <= 0) throw ValueLessThanZeroException("Length needs to be more than zero")

        this.name = name
        this.coordinates = coordinates
        this.oscarsCount = oscarsCount
        this.length = length
        this.genre = genre
        this.mpaaRating = mpaaRating
        this.screenWriter = screenWriter

        this.id = id

        cntId = max(id, cntId)
        this.creationDate = LocalDate.now()
    }

    constructor(name: String, coordinates: Coordinates,
                oscarsCount: Long, length: Int,
                genre: MovieGenre, mpaaRating: MpaaRating,
                screenWriter: Person) {
        if (name.isEmpty()) throw EmptyStringException("Movie name can't be empty")
        if (name.contains(",")) throw EmptyStringException("Movie name can't use symbol ','")
        if (oscarsCount <= 0) throw ValueLessThanZeroException("Oscars count needs to be more than zero")
        if (length <= 0) throw ValueLessThanZeroException("Length needs to be more than zero")

        this.name = name
        this.coordinates = coordinates
        this.oscarsCount = oscarsCount
        this.length = length
        this.genre = genre
        this.mpaaRating = mpaaRating
        this.screenWriter = screenWriter
        id = giveId()
        creationDate = LocalDate.now()

    }

    private companion object {
        var cntId: Long = 0

        /**
         * Giving id to movie instance method
         *
         * @return id of new movie [Long]
         */
        @JvmStatic
        fun giveId(): Long {
            cntId += 1
            return cntId
        }
    }

    /**
     * Name getter method
     *
     * @return movie name [String]
     * @author Markov Maxim 2023
     */
    fun getName() = this.name

    /**
     * Coordinates getter method
     *
     * @return movie coordinates [Coordinates]
     * @author Markov Maxim 2023
     */
    fun getCoordinates() = this.coordinates

    /**
     * Oscars count getter method
     *
     * @return movie oscars count [Int]
     * @author Markov Maxim 2023
     */
    fun getOscarsCount() = this.oscarsCount

    /**
     * Length getter method
     *
     * @return movie length [Long]
     * @author Markov Maxim 2023
     */
    fun getLength() = this.length

    /**
     * Genre getter method
     *
     * @return movie genre [MovieGenre]
     * @author Markov Maxim 2023
     */
    fun getGenre() = this.genre

    /**
     * Mpaa rating getter method
     *
     * @return movie mpaa rating [mpaaRating]
     * @author Markov Maxim 2023
     */
    fun getMpaaRating() = this.mpaaRating
    /**
     * Sreenwriter's name getter method
     *
     * @return movie id [Long]
     * @author Berman Denis 2023
     */
    fun getScreenwriter() = this.screenWriter

    /**
     * Id getter method
     *
     * @return movie id [Long]
     * @author Markov Maxim 2023
     */
    fun getId() = this.id

    /**
     * Creation date getter method
     *
     * @return movie creation date [LocalDate]
     * @author Markov Maxim 2023
     */
    fun getCreationDate() = this.creationDate

    override fun toString(): String {
        return "ID: $id\nName: $name\nCoordinates: $coordinates\nCreation date: $creationDate\n" +
                "Oscars count: $oscarsCount\nLenght: $length\n Genre: $genre\n Mpaa rating: $mpaaRating\n" +
                "Screen writer: $screenWriter"
    }
}

