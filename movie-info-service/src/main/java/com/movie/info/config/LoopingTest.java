package com.movie.info.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.lang.RandomStringUtils;

public class LoopingTest
{
    public static void main( String[] args )
    {
        List<String> stringList = new ArrayList<>();

        System.out.println( "start time-->" + new Date() );
        IntStream.range( 0, 10000000 ).forEach( index-> stringList.add( RandomStringUtils.randomAlphabetic( 10 ) ) );

    /*    for( int i = 0; i < 10000000; i++ )
        {
            stringList.add( RandomStringUtils.randomAlphabetic( 10 ) );
        }*/
        System.out.println( "end time-->" + new Date() );

/*        start time-->Sat Sep 05 22:16:21 IST 2020
          end time-->Sat Sep 05 22:16:28 IST 2020*/
    }
}
