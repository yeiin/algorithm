SELECT ANIMAL_INS.ANIMAL_ID, ANIMAL_INS.NAME
FROM ANIMAL_INS
JOIN ANIMAL_OUTS ON ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID
WHERE ANIMAL_INS.DATETIME>ANIMAL_OUTS.DATETIME
ORDER BY ANIMAL_INS.DATETIME