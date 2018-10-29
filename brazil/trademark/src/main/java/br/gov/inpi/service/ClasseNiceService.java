package br.gov.inpi.service;

import br.gov.inpi.database.DatabaseConfig;
import br.gov.inpi.domain.ClasseNice;
import br.gov.inpi.mapper.ClasseNiceMapper;
import org.apache.ibatis.session.SqlSession;

public class ClasseNiceService {

    public void inserir(ClasseNice classeNice) {
        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        try {
            ClasseNiceMapper classeNiceMapper = sqlSession.getMapper(ClasseNiceMapper.class);


            ClasseNice cn = classeNiceMapper.getClasseNice(classeNice);

            if (cn == null) {
                classeNiceMapper.inserir(classeNice);
            } else {
                classeNice.setId(cn.getId());
                classeNiceMapper.atualizar(classeNice);
            }

            sqlSession.commit();

        } finally {
            sqlSession.close();
        }

    }

    public ClasseNice getClasseNice(ClasseNice classeNice) {
        SqlSession sqlSession = DatabaseConfig.getSqlSessionFactory().openSession();

        try {
            ClasseNiceMapper classeNiceMapper = sqlSession.getMapper(ClasseNiceMapper.class);

            return classeNiceMapper.getClasseNice(classeNice);

        } finally {
            sqlSession.close();
        }
    }

}
