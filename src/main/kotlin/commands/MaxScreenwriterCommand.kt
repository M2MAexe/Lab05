package commands

import movies.MovieManager
import run.ConsoleManager
import user_exceptions.CommandArgumentException

class MaxScreenwriterCommand(private val movieManager: MovieManager): Command() {
    /**
     * Get information about command abstract method
     *
     * @return information about command [String]
     * @author Berman Denis 2023
     */
    override fun getDescription() = "Command is printing all the elements, which value of screenwriter is maximum\n" +
            "[Command]: max_by_screenwriter"

    /**
     * Get name of command abstract method
     *
     * @return name of command [String]
     * @author Berman Denis 2023
     */
    override fun getName() = "max_by_screenwriter"

    /**
     * Execute command abstract method.
     *
     * @param argument if it is needed [String]
     * @return none
     * @author Berman Denis 2023
     */
    override fun execute(argument: String?): Boolean {
        if (argument != null) throw CommandArgumentException()

        val movies = movieManager.getMovieQueue()
        var maxValue: Int=-1
        for (movie in movies){
            if (movie.getScreenwriter().getHeight()>maxValue){
                maxValue= movie.getScreenwriter().getHeight()
            }
        }
        for (movie in movies){
            if (movie.getScreenwriter().getHeight()==maxValue){
                ConsoleManager.consolePrint("Movie info: $movie\n")
            }
        }
    return true
    }
}