
SELECT o.order_id, t.first_name, t.last_name, p.name, n.nature_name, o.price, o.order_time 
FROM pokemon as p
INNER JOIN pokemon_orders as po
    ON p.pokemon_id  = po.pokemon_id
INNER JOIN orders as o
    ON po.order_id  = o.order_id
    INNER JOIN trainers AS t
    ON o.trainer_id = t.trainer_id 
    INNER JOIN nature n
    ON o.nature_id = n.nature_id
WHERE o.order_id = 5