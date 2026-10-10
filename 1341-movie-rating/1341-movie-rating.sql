# Write your MySQL query statement below
(
    SELECT U.name AS results
    FROM MovieRating MR
    JOIN Users U ON MR.user_id = U.user_id
    GROUP BY U.user_id, U.name
    ORDER BY COUNT(MR.movie_id) DESC, U.name ASC
    LIMIT 1
)

UNION ALL

(
    SELECT M.title AS results
    FROM MovieRating MR
    JOIN Movies M ON MR.movie_id = M.movie_id
    WHERE MR.created_at >= '2020-02-01' AND MR.created_at <= '2020-02-29'
    GROUP BY M.movie_id, M.title
    ORDER BY AVG(MR.rating) DESC, M.title ASC
    LIMIT 1
);