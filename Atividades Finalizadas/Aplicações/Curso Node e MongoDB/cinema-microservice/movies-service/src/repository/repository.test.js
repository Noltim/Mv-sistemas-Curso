const {test, expect, beforeAll} = require("@jest/globals")
const repository = require("./repository")

let testMovieId = null;

beforeAll( async () => {
    const movies = await repository.getAllMovies();
    testMovieId = movies[0]._id;
})


test('getAllMovies', async () => {
    const allMovies = await repository.getAllMovies();
    expect(Array.isArray(allMovies)).toBeTruthy();
    expect(allMovies.length).toBeTruthy();
})

test('getMoviesById', async () => {
    const movie = await repository.getMovieById(testMovieId)
    expect(movie).toBeTruthy();
    expect(movie._id).toEqual(testMovieId)
})

test('getMoviesPremieres', async () => {
    const monthAgo = new Date();
    monthAgo.setMonth(-1)
 
    const movies = await repository.getMoviesPremieres();
  expect(Array.isArray(movies)).toBeTruthy();
  expect(movies.length).toBeTruthy();
  expect(movies[0].dataLancamento.getTime()).toBeGreaterThanOrEqual(monthAgo.getTime())
})