package br.com.codenation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

public class StatisticUtilTest {

	@Test
	public void testAverage() {
		assertEquals(3, StatisticUtil.average(new int[] {1,2,3,4,5}));
	}

	@Test
	public void testAverageWithEmptyArray() {
		assertEquals(StatisticUtil.ERROR, StatisticUtil.average(new int[] {}));
	}

	@Test
	public void testMode() {
		assertEquals(3, StatisticUtil.mode(new int[] {1,2,3,3}));
	}

	@Test
	public void testModeEmptyArray() {
		assertEquals(StatisticUtil.ERROR, StatisticUtil.mode(new int[]{}));
	}

	@Test(expected = RuntimeException.class)
	public void testRepetedModeEmptyArray() {
		StatisticUtil.mode(new int[] {}, true);
	}

	@Test
	public void testMode3Repete3E4Repete3() {
		List<Map.Entry<Integer, IntSummaryStatistics>> mode = StatisticUtil.mode(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8}, true);

		assertEquals(mode.size(), 2);

		assertEquals(mode.get(0).getKey().intValue(), 3);
		assertEquals(mode.get(0).getValue().getCount(), 3);

		assertEquals(mode.get(1).getKey().intValue(), 4);
		assertEquals(mode.get(1).getValue().getCount(), 3);
	}

	@Test
	public void testMode3Repete3() {
		List<Map.Entry<Integer, IntSummaryStatistics>> mode = StatisticUtil.mode(new int[]{1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 7, 8}, true);

		assertEquals(mode.size(), 1);

		assertEquals(mode.get(0).getKey().intValue(), 3);
		assertEquals(mode.get(0).getValue().getCount(), 3);
	}

	@Test
	public void testMode1Repete2E4Repete2E8Repete2() {
		List<Map.Entry<Integer, IntSummaryStatistics>> mode = StatisticUtil.mode(new int[]{1, 1, 2, 3, 4, 4, 5, 6, 7, 8, 8}, true);

		assertEquals(mode.size(), 3);

		assertEquals(mode.get(0).getKey().intValue(), 1);
		assertEquals(mode.get(0).getValue().getCount(), 2);

		assertEquals(mode.get(1).getKey().intValue(), 4);
		assertEquals(mode.get(1).getValue().getCount(), 2);

		assertEquals(mode.get(2).getKey().intValue(), 8);
		assertEquals(mode.get(2).getValue().getCount(), 2);
	}

	@Test
	public void testModeOnlyOneElement() {
		List<Map.Entry<Integer, IntSummaryStatistics>> mode = StatisticUtil.mode(new int[]{1}, true);

		assertEquals(mode.size(), 1);

		assertEquals(mode.get(0).getKey().intValue(), 1);
		assertEquals(mode.get(0).getValue().getCount(), 1);
	}

	@Test
	public void testMedian() {
		assertEquals(3, StatisticUtil.median(new int[] {1,2,3,4,5}));
	}

	@Test
	public void testMedianWithEvenElementsSize() {
		// 30  50  99  100
		// ( 50 + 99 ) / 2
		assertEquals(74, StatisticUtil.median(new int[] {50, 30, 100, 99}));
	}

	@Test
	public void testMedianWithOddElementsSize() {
		// 1  30  50  99  100
		// 50
		assertEquals(50, StatisticUtil.median(new int[] {50, 30, 100, 99, 1}));
	}

	@Test
	public void testMedianWithEmptyArray() {
		assertEquals(StatisticUtil.ERROR, StatisticUtil.median(new int[] {}));
	}
}
